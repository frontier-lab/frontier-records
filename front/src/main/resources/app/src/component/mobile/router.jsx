import React, { Component } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom'

import Main from './main/main';
import LoginMain from './account/login-main';
import SignupMain from './account/signup-main';

class Router extends Component {

    render() {
        return (
            <div>
                <Switch>
                    <Route exact path="/" component={Main} />
                    <Route path="/log-in" component={LoginMain}/>
                    <Route path="/sign-up" component={SignupMain}/>
                </Switch>

            </div>
        )
    }
}

export default Router;