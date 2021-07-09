// Step 3: Create reducers for the action types

import { combineReducers } from "redux";

import gistifyReducer from "./gistifyReducer";

export default combineReducers({ gistifyReducer });