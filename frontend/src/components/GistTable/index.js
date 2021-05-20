import jwt_decode from "jwt-decode";
import Cookies from 'universal-cookie';
import React, { useContext, useState, useEffect, useRef } from 'react';
import ReactDOM from 'react-dom';
import 'antd/dist/antd.css';
import { Table, Input, Button, Popconfirm, Form } from 'antd';
import { updateGists } from "./../../redux/actions";
import { connect } from 'react-redux';
const EditableContext = React.createContext(null);
const cookies = new Cookies();

class GistTable extends React.Component {
    async getData(url, requestOptions) {
        const response = await fetch(url,requestOptions);
        return response.json(); 
    }

    async componentDidMount(){
        let url = `${process.env.REACT_APP_API_ENDPOINT}/gists`
        let jwtToken = cookies.get('token')
        let headers = new Headers();
        headers.append("Authorization", `Bearer ${jwtToken}`) 
        let requestOptions = {
            method: 'GET',
            headers: headers,
            redirect: 'follow'
        };
        let gistData = await this.getData(url, requestOptions)
        this.props.updateGists(gistData["gistData"])
    }

    handleDelete = (key) => {
        const dataSource = this.props.gists;
        let url = `${process.env.REACT_APP_API_ENDPOINT}/gists/${key}`
        let jwtToken = cookies.get('token')
        let headers = new Headers();
        headers.append("Authorization", `Bearer ${jwtToken}`) 
        let requestOptions = {
            method: 'DELETE',
            headers: headers,
            redirect: 'follow'
        };
        fetch(url, requestOptions)
            .then(response => response.json())
            .then(result => console.log("Key: ,Result: ",key, result))
            .catch(error => console.log('error', error));
        
        this.props.updateGists(dataSource.filter((item) => item.key !== key))
    };

    render(){
        const  dataSource  = this.props.gists;
        const dataSourceLength = dataSource.length;
        
        console.log("Data source: ", dataSource);
        let columns = [
            {
              title: 'Filename',
              dataIndex: 'filename',
            },
            {
              title: 'URL',
              dataIndex: 'url',
              render: (text, row, index) => {
                return <a href={text} target="_blank">{text}</a>;
              },
            },
            {
              title: 'Created at',
              dataIndex: 'created_at',
            },
            {
              title: 'Operation',
              dataIndex: 'operation',
              render: (_, record) =>
              this.props.gists.length >= 1 ? (
                  <Popconfirm title="Sure to delete?" onConfirm={() => this.handleDelete(record.key)}>
                    <a>Delete</a>
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
  return state.anyJsonReducer;
}

const mapDispatchToProps = (dispatch) => {
  return {
    updateGists: (gists) => dispatch(updateGists(gists)),
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(GistTable);

