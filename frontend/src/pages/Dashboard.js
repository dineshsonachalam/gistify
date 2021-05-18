import React from 'react';
import NavBar from "../components/NavBar"
import PageFooter from "../components/Footer"
import { Layout} from 'antd';
const { Content } = Layout;

class Dashboard extends React.Component {
  render(){
    return (
      <div>
        <NavBar />  
        <Content>
            <div style={{ padding: 24}}>
              <p>Dashboard Page</p>
            </div>
        </Content>
        <PageFooter/>
      </div>
    );
  }
}

export default Dashboard;