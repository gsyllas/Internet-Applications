import React, { Component } from "react";
import "./App.css";
import Navbar from "./components/nav";
import kobeBackground from "./kobeBackground.jpg";
import GetPlayerData from "./components/getPlayerData";
import GetBestScorersData from "./components/getBestScorersData";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

class App extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <React.Fragment>
        <div
          className="App"
          style={{ backgroundImage: `url(${kobeBackground})` }}
        >
          <div className="App-content">
            <Navbar></Navbar>

            <GetPlayerData></GetPlayerData>

            <GetBestScorersData></GetBestScorersData>
          </div>
        </div>
      </React.Fragment>
    );
  }
}

export default App;
