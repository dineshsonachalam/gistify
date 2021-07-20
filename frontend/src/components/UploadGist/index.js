import { Upload, Button, message } from "antd";
import { UploadOutlined } from "@ant-design/icons";
import { addGist } from "./../../redux/actions";
import { connect } from "react-redux";
import React from "react";
import { PageHeader} from "antd";
import reqwest from "reqwest";
import Cookies from "universal-cookie";
const cookies = new Cookies();


class UploadGist extends React.Component {
  state = {
    fileList: [],
    uploading: false,
  };

  handleUpload = () => {
    const { fileList } = this.state;
    const formData = new FormData();
    fileList.forEach(file => {
      formData.append("uploadfile", file, file.name);
    });

    this.setState({
      uploading: true,
    });

    // You can use any AJAX library you like
    let gistUrl = `${process.env.REACT_APP_API_ENDPOINT}/gists`
    let jwtToken = cookies.get("token", {path: "/", domain: `${process.env.REACT_APP_COOKIE_DOMAIN}`});    
    cookies.set("token", jwtToken, {path: "/", domain: `${process.env.REACT_APP_COOKIE_DOMAIN}`});    
    
    reqwest({
      url: gistUrl,
      method: "post",
      headers: {
        "Authorization": `Bearer ${jwtToken}`
      },      
      processData: false,
      data: formData,
      success: (resp) => {
        let gist_id = resp.gist_id
        let url = `${process.env.REACT_APP_API_ENDPOINT}/gists/${gist_id}`
        let headers = new Headers();
        headers.append("Authorization", `Bearer ${jwtToken}`) 
        let requestOptions = {
            method: "GET",
            headers: headers,
            redirect: "follow"
        }; 
        fetch(url, requestOptions)
          .then(response => response.json())
          .then(result => this.props.addGist(result.gistData))
          .catch(error => console.log("error", error));
        this.setState({
          fileList: [],
          uploading: false,
        });
        message.success(resp.message);
      },
      error: () => {
        this.setState({
          uploading: false,
        });
        message.error("Conversion failed");
      },
    });
  };

  render() {
    const { uploading, fileList } = this.state;
    const props = {
      onRemove: file => {
        this.setState(state => {
          const index = state.fileList.indexOf(file);
          const newFileList = state.fileList.slice();
          newFileList.splice(index, 1);
          return {
            fileList: newFileList,
          };
        });
      },
      beforeUpload: file => {
        if(this.state.fileList<2){
          this.setState(state => ({
            fileList: [...state.fileList, file],
          }));
        }


        return false;
      },
      fileList,
    };

    return (
      <PageHeader
      title="Convert YAML/TOML/CSV/EXCEL to JSON and upload to Gist"
              >
        <Upload {...props}>
          <Button icon={<UploadOutlined />}>Select File</Button>
        </Upload>
        <Button
          type="primary"
          onClick={this.handleUpload}
          disabled={fileList.length === 0 || this.props.isLoggedInStatus === false}
          loading={uploading}
          style={{ marginTop: 16 }}
        >
          {uploading ? "Uploading" : "Start conversion"}
        </Button>
      </PageHeader>
    );
  }
}

// https://stackoverflow.com/a/50225424
const mapStateToProps = (state) => {
  return state.gistifyReducer;
}

const mapDispatchToProps = (dispatch) => {
  return {
    addGist: (gist) => dispatch(addGist(gist)),
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(UploadGist);

