// Step 2: Create Actions for your Action Types

import {UPDATE_IS_LOGGED_IN_STATUS, UPDATE_USER_ID, UPDATE_USERNAME, UPDATE_GISTS, ADD_GIST} from "./actionTypes";

export const updateIsLoggedInStatus = (isLoggedInStatus) => {
  return {
            type: UPDATE_IS_LOGGED_IN_STATUS,
            payload: {
              isLoggedInStatus: isLoggedInStatus
            }
  }
}

export const updateUserId = (userId) => {
    return {
              type: UPDATE_USER_ID,
              payload: {
                userId: userId
              }
    }
}

export const updateUsername = (username) => {
  return {
            type: UPDATE_USERNAME,
            payload: {
              username: username
            }
  }
}

export const updateGists = (gists) => {
  return {
            type: UPDATE_GISTS,
            payload: {
              gists: gists
            }
  }
}

export const addGist = (gist) => {
  return {
            type: ADD_GIST,
            payload: {
              gist: gist
            }
  }
}

