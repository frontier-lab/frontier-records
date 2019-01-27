import React, { Component } from 'react';
import { BrowserRouter, Route } from 'react-router-dom'

import LoginMain from './account/login-main';
import SignupMain from './account/signup-main';

class Router extends Component {

    render() {
        return (
            <div>
                <Route path="/log-in" component={LoginMain}/>
                <Route path="/sign-up" component={SignupMain}/>
            </div>
        )
    }
}

export default Router;