import React from "react";
import ReactDOM from "react-dom";
import { HashRouter } from 'react-router-dom'
import 'antd/dist/antd.css'
import { Provider } from "react-redux";
// Step 5: Add the redux store to the React App
import store from "./redux/store";

import App from "./App";

const rootElement = document.getElementById("root");
ReactDOM.render(
  <HashRouter>
  <Provider store={store}>
    <App />
  </Provider>
  </HashRouter>,
  rootElement
);