import { Upload, Button, Space } from 'antd';
import { UploadOutlined } from '@ant-design/icons';
import { connect } from 'react-redux';
import React from 'react';
import { PageHeader} from 'antd';


class UploadGist extends React.Component {
  render(){
    return (
        <div>
            <PageHeader
                title="Convert YAML/TOML/CSV/EXCEL to JSON and upload to Gist"
                        >
                  <Space direction="vertical" style={{ width: '100%' }} size="large">
                      <Upload
                        action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
                        listType="picture"
                        maxCount={1}
                      >
                      <Button icon={<UploadOutlined />}>Select File</Button>
                    </Upload>
                  </Space>
            </PageHeader>
        </div>

    );
  }
} 
// https://stackoverflow.com/a/50225424
const mapStateToProps = (state) => {
  return state.anyJsonReducer;
}

const mapDispatchToProps = (dispatch) => {
  return {}
}

export default connect(mapStateToProps, mapDispatchToProps)(UploadGist);

