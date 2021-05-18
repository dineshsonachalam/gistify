// Step 2: Create Actions for your Action Types

import {UPDATE_IS_LOGGED_IN_STATUS, UPDATE_USER_ID, UPDATE_USERNAME, UPDATE_GISTS} from './actionTypes';

export const updateIsLoggedInStatus = (isLoggedInStatus) => {
  return {
            type: UPDATE_IS_LOGGED_IN_STATUS,
            payload: {
              isLoggedInStatus: isLoggedInStatus
            }
  }
}

export const updateUserId = (user_id) => {
    return {
              type: UPDATE_USER_ID,
              payload: {
                user_id: user_id
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

