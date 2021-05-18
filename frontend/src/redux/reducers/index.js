// Step 3: Create reducers for the action types

import { combineReducers } from "redux";

import anyJsonReducer from "./anyJsonReducer";

export default combineReducers({ anyJsonReducer });