import { Redirect } from "react-router"
import React from "react";
import NavBar from "../components/NavBar"
import UploadGist from "../components/UploadGist"
import PageFooter from "../components/Footer"
import GistTable from "../components/GistTable"
import { Layout} from "antd";
import Cookies from "universal-cookie";
import { updateIsLoggedInStatus, updateUserId, updateUsername } from "./../redux/actions";
import { connect } from "react-redux";
import jwt_decode from "jwt-decode";
const cookies = new Cookies();
const { Content } = Layout;

class Dashboard extends React.Component {
  DashboardPage(jwtToken){
    if(!jwtToken){
      return(<Redirect to="/" />);
    }else{
      let decodedJwtToken = jwt_decode(jwtToken);
      this.props.updateIsLoggedInStatus(true)
      this.props.updateUserId(decodedJwtToken.userId)
      this.props.updateUsername(decodedJwtToken.username)
      return (
        <div>
            <NavBar />  
            <Content>
                <div style={{ padding: 24}}>
                  <UploadGist />
                </div>
                <div style={{ padding: 24}}>
                  {this.props.isLoggedInStatus &&
                    <GistTable />
                  }
                </div>
            </Content>
            <PageFooter/>
        </div>
      );
    }
  } 
  render(){
    return (
        <div>
          {this.DashboardPage(cookies.get("token", {path: "/", domain: `${process.env.REACT_APP_COOKIE_DOMAIN}`}))}
        </div>
    );
  }
}

// https://stackoverflow.com/a/50225424
const mapStateToProps = (state) => {
  return state.gistifyReducer;
}

const mapDispatchToProps = (dispatch) => {
  return {
    updateIsLoggedInStatus: (isLoggedInStatus) => dispatch(updateIsLoggedInStatus(isLoggedInStatus)),
    updateUserId: (user_id) => dispatch(updateUserId(user_id)),
    updateUsername: (username) => dispatch(updateUsername(username)),
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(Dashboard);

