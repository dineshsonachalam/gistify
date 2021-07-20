// Step 3: Create reducers for the action types
import {UPDATE_IS_LOGGED_IN_STATUS, UPDATE_USER_ID, UPDATE_USERNAME, UPDATE_GISTS, ADD_GIST} from "../actionTypes";

const initialState = {
    isLoggedInStatus: false,
    userId : "",
    username: "",
    gists: []
};

const gistifyReducer = (state=initialState, actions) => {
    switch(actions.type) {
        case UPDATE_IS_LOGGED_IN_STATUS:
            return {...state, isLoggedInStatus: actions.payload.isLoggedInStatus};
        case UPDATE_USER_ID:
            return {...state, userId: actions.payload.userId};
        case UPDATE_USERNAME:
            return {...state, username: actions.payload.username};
        case UPDATE_GISTS:
            return {...state, gists: [...actions.payload.gists]};
        case ADD_GIST:
            let gist = actions.payload.gist;
            if (Object.keys(gist).length){
                let gists = state.gists;
                return {...state, gists: [gist, ...gists]};
            }else{
                return {...state, gists: [...state.gists]};
            }
        default:
            return {...state};
    }
};

export default gistifyReducer;



