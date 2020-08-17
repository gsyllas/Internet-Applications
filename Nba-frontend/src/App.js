import React, { Component } from "react";
import "./App.css";
import { HashRouter as Router, Route, Redirect } from "react-router-dom";
import Navbar from "./components/nav";
import kobeBackground from "./kobeBackground.jpg";
import GetPlayerData from "./components/getPlayerData";
import GetBestScorersData from "./components/getBestScorersData";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { Button } from "react-bootstrap";

class App extends Component {
  state = {
    playerData: false,
    bestScorersData: false,
  };
  constructor(props) {
    super(props);
    this.routeToPlayerData = this.routeToPlayerData.bind(this);
    this.routeToBestScorersData = this.routeToBestScorersData.bind(this);
  }
  routeToPlayerData() {
    this.setState({ bestScorersData: false });
    this.setState({ playerData: true });
    console.log(this.state.playerData);
  }
  routeToBestScorersData() {
    this.setState({ playerData: false });
    this.setState({ bestScorersData: true });
    console.log(this.state.bestScorersData);
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

            <Router>
              <Button
                variant="dark"
                style={{ margin: 10 }}
                onClick={this.routeToPlayerData}
              >
                Search for your favorite Player
              </Button>
              {this.state.bestScorersData ? (
                <Redirect to="/getBestScorersData" />
              ) : (
                ""
              )}
              <Button
                variant="dark"
                style={{ margin: 10 }}
                onClick={this.routeToBestScorersData}
              >
                Find a season's 15 best scorers
              </Button>
              {this.state.playerData ? <Redirect to="/getPlayerData" /> : ""}
              <Route path="/getPlayerData" component={GetPlayerData} />
              <Route
                path="/getBestScorersData"
                component={GetBestScorersData}
              />
            </Router>
          </div>
        </div>
      </React.Fragment>
    );
  }
}

export default App;
