import React, { Component } from 'react'
import ReactDOM from "react-dom";
import {Card, Col, Image, Media, Row} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import AudioPlayer from "react-h5-audio-player";

class MusicPlayer extends Component {

    componentDidMount = () => {
        let node = ReactDOM.findDOMNode(this);
        let time = node.querySelector(".react-h5-audio-player .progress-bar-wrapper .audio-info .time");
        time.firstElementChild.nextSibling.textContent = ""
    };

    render() {
        return (
            <Card className="mt-4 rounded-2">
                <Card.Body className="music_layer">
                    <Media>
                        <Image
                            rounded
                            width={64}
                            height={64}
                            className="mr-3"
                            src={this.props.image}
                            alt="Generic placeholder"
                        />
                        <Media.Body className="title_layer">
                            <h5 className="artist">{this.props.artist}</h5>
                            <p>{this.props.title}</p>
                        </Media.Body>
                    </Media>
                    <Row className="mt-2">
                        <Col xs={6} md={4}>
                            <Col xs={12} className="p-0 m-0 text-monospace" >
                                Like <span className="float-right">99</span>
                            </Col>
                            <Col xs={12} className="p-0 m-0 text-monospace" >
                                Comment <span className="float-right">999</span>
                            </Col>
                        </Col>
                        <Col xs={6} md={8} className="text-right">
                            <span className="m-1 text-150p"><FontAwesomeIcon className="align-middle cursor-pointer" icon={["fas", "share-alt"]} size="lg"/></span>
                            <span className="m-1 text-150p"><FontAwesomeIcon className="align-middle cursor-pointer" icon={["far", "heart"]} size="lg"/> </span>
                            <span className="m-1 text-150p"><FontAwesomeIcon className="align-middle cursor-pointer" icon={["far", "comment-dots"]} size="lg"/> </span>
                            <span className="m-1 text-150p"><FontAwesomeIcon className="align-middle cursor-pointer" icon={["far", "file-alt"]} size="lg"/> </span>
                        </Col>
                    </Row>
                    <Row>
                        <Col xs={12} className="audio_player">
                            <AudioPlayer
                                ref={c => (this.player = c)}
                                preload="metadata"
                                volume={1}
                                src={this.props.src}
                                onPlay={e => console.log("onPlay")}/>
                        </Col>
                    </Row>
                </Card.Body>
            </Card>
        )
    }
}

export default MusicPlayer;