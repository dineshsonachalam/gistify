import React from "react";
// import PageFooter from "../components/Footer"
import Login from "./pages/Login"
import Dashboard from "./pages/Dashboard"
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";

function App() {
  return (
    <Router>
      <div>
        <Switch>
          <Route path="/" exact component={Login}/>
          <Route path="/:username" exact component={Dashboard}/>
        </Switch>
      </div>
    </Router>
  );
}

export default App;