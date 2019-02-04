import React, { Component } from 'react';
import { BrowserRouter, Route } from 'react-router-dom'

import { library } from '@fortawesome/fontawesome-svg-core';

import { fas } from '@fortawesome/free-solid-svg-icons';
import { far } from '@fortawesome/free-regular-svg-icons';
library.add(fas, far);

import 'bootstrap/dist/css/bootstrap.min.css';
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