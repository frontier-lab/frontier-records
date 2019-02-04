import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom'

import Main from './main/main';
import LoginMain from './account/login-main';
import SignupMain from './account/signup-main';

class Router extends Component {

    render() {
        return (
            <div>
                <Switch>
                    <Route exact path="/log-in" component={LoginMain}/>
                    <Route exact path="/sign-up" component={SignupMain}/>
                    <Route path="/" component={Main} />
                </Switch>
            </div>
        )
    }
}

export default Router;