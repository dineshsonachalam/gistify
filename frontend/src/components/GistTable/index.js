import Cookies from "universal-cookie";
import React from "react";
import "antd/dist/antd.css";
import { Table, Popconfirm} from "antd";
import { updateGists } from "./../../redux/actions";
import { connect } from "react-redux";
const cookies = new Cookies();

class GistTable extends React.Component {
    async getData(url, requestOptions) {
        const response = await fetch(url,requestOptions);
        return response.json(); 
    }

    async componentDidMount(){
        let url = `${process.env.REACT_APP_API_ENDPOINT}/gists`
        let jwtToken = cookies.get("token", {path: "/", domain: `${process.env.REACT_APP_COOKIE_DOMAIN}`});
        let headers = new Headers();
        headers.append("Authorization", `Bearer ${jwtToken}`) 
        let requestOptions = {
            method: "GET",
            headers,
            redirect: "follow"
        };
        let gistData = await this.getData(url, requestOptions)
        this.props.updateGists(gistData["gistData"])
    }

    handleDelete = (key) => {
        const dataSource = this.props.gists;
        let url = `${process.env.REACT_APP_API_ENDPOINT}/gists/${key}`
        let jwtToken = cookies.get("token", {path: "/", domain: `${process.env.REACT_APP_COOKIE_DOMAIN}`});
        let headers = new Headers();
        headers.append("Authorization", `Bearer ${jwtToken}`) 
        let requestOptions = {
            method: "DELETE",
            headers,
            redirect: "follow"
        };
        fetch(url, requestOptions)
            .then(response => response.json())
            .then(result => console.log("Key: ,Result: ",key, result))
            .catch(error => console.log("error", error));
        this.props.updateGists(dataSource.filter((item) => item.key !== key));
    };

    render(){
        const  dataSource  = this.props.gists;
        let columns = [
            {
              title: "Filename",
              dataIndex: "filename",
            },
            {
              title: "Generated from",
              dataIndex: "generatedFrom",
            },
            {
              title: "URL",
              dataIndex: "url",
              render: (text, row, index) => {
                return <a href={text} target="_blank" rel="noreferrer">{text}</a>;
              },
            },
            {
              title: "Created at",
              dataIndex: "createdAt",
            },
            {
              title: "Operation",
              dataIndex: "operation",
              render: (_, record) =>
              this.props.gists.length >= 1 ? (
                  <Popconfirm title="Sure to delete?" onConfirm={() => this.handleDelete(record.key)}>
                    {// eslint-disable-next-line
                    }<a>Delete</a>
                  </Popconfirm>
                ) : null,
            },
        ];
        return (
            <div key={this.props.gists.length + 1}>
                <Table
                        key={this.props.gists.length}
                        bordered
                        dataSource={dataSource}
                        columns={columns}
                />
            </div>
        );
    }
} 
// https://stackoverflow.com/a/50225424
const mapStateToProps = (state) => {
  return state.gistifyReducer;
};

const mapDispatchToProps = (dispatch) => {
  return {
    updateGists: (gists) => dispatch(updateGists(gists)),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(GistTable);

