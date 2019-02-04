import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom'

import ContentTab from './content-tab'
import HomeMain from './home/main'
import AlbumMain  from './album/main'
import ArtistMain  from './artist/main'

class Container extends Component {

    render() {
        return (
            <div>
                <ContentTab />
                <Switch>
                    <Route path="/home" component={HomeMain}/>
                    <Route path="/artist" component={ArtistMain}/>
                    <Route path="/album" component={AlbumMain}/>
                </Switch>
            </div>
        )
    }
}

export default Container;