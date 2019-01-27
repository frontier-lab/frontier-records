import React, { Component } from 'react';
import { BrowserRouter, Route } from 'react-router-dom'

import '../../assets/mobile/css/common_test.css';
import '../../assets/mobile/css/member_test.css'

import Router from './router';
import Dimd from '../common/dimd';

import Alert from 'react-s-alert';
import '../common/alert'


class App extends Component {

    render() {
        return (
            <div>
                <BrowserRouter>
                    <Router />
                </BrowserRouter>
                <Dimd/>
                <Alert stack={{limit: 3}}/>
            </div>
        )
    }
}

export default App;