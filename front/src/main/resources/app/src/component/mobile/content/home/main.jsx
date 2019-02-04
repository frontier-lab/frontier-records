import React, { Component } from 'react';

import sample64 from '../../../../assets/mobile/sample/img/64x64.svg'
import MusicPlayer from "../player/music-player";

class HomeMain extends Component {

    render() {
        return (
            <div className="container home">
                <MusicPlayer
                    image={sample64}
                    artist={"이름 없는 가수"}
                    title={"노래 제목이 없는 노래."}
                    src={"https://designshack.net/tutorialexamples/html5-audio-player/media/evidence-song.mp3"}
                />
                <MusicPlayer
                    image={sample64}
                    artist={"이름 없는 가수"}
                    title={"노래 제목이 없는 노래."}
                    src={"https://designshack.net/tutorialexamples/html5-audio-player/media/evidence-song.mp3"}
                />
                <MusicPlayer
                    image={sample64}
                    artist={"이름 없는 가수"}
                    title={"노래 제목이 없는 노래."}
                    src={"https://designshack.net/tutorialexamples/html5-audio-player/media/evidence-song.mp3"}
                />
                <MusicPlayer
                    image={sample64}
                    artist={"이름 없는 가수"}
                    title={"노래 제목이 없는 노래."}
                    src={"https://designshack.net/tutorialexamples/html5-audio-player/media/evidence-song.mp3"}
                />
                <MusicPlayer
                    image={sample64}
                    artist={"이름 없는 가수"}
                    title={"노래 제목이 없는 노래."}
                    src={"https://designshack.net/tutorialexamples/html5-audio-player/media/evidence-song.mp3"}
                />
                <MusicPlayer
                    image={sample64}
                    artist={"이름 없는 가수"}
                    title={"노래 제목이 없는 노래."}
                    src={"https://designshack.net/tutorialexamples/html5-audio-player/media/evidence-song.mp3"}
                />

            </div>
        )
    }

}

export default HomeMain;