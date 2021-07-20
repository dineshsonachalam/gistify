import { connect } from "react-redux";
import React from "react";
import { Layout } from "antd";
const { Footer } = Layout;


class PageFooter extends React.Component {
  render(){
    return (
        <div  style={ (this.props.isLoggedInStatus) ? {}: { position:"absolute", bottom:0, color: "blue", width:"100%"  } }>
            <Footer style={{ textAlign: "center" }}> Developed with ❤️ by <a href="https://github.com/dineshsonachalam/gistify" rel="noreferrer" target="_blank">Dinesh Sonachalam</a> © {(new Date().getFullYear())}</Footer>
        </div>
    );
  }
} 
// https://stackoverflow.com/a/50225424
const mapStateToProps = (state) => {
  return state.gistifyReducer;
}

const mapDispatchToProps = (dispatch) => {
  return {}
}

export default connect(mapStateToProps, mapDispatchToProps)(PageFooter);

