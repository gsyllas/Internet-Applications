import React, { Component } from "react";
import "./App.css";
import { HashRouter as Router, Route, Redirect } from "react-router-dom";
import Navbar from "./components/nav";
import kobeBackground from "./kobeBackground.jpg";
import GetPlayerData from "./components/getPlayerData";
import GetBestScorersData from "./components/getBestScorersData";
import KobeVideo from "./components/kobeVideo";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { Button } from "react-bootstrap";

class App extends Component {
  state = {
    playerData: false,
    bestScorersData: false,
    tribute: false,
  };
  constructor(props) {
    super(props);
    this.routeToPlayerData = this.routeToPlayerData.bind(this);
    this.routeToBestScorersData = this.routeToBestScorersData.bind(this);
    this.routeToTribute = this.routeToTribute.bind(this);
  }
  routeToPlayerData() {
    this.setState({ tribute: false });
    this.setState({ bestScorersData: false });
    this.setState({ playerData: true });
    console.log(this.state.playerData);
  }
  routeToBestScorersData() {
    this.setState({ tribute: false });
    this.setState({ playerData: false });
    this.setState({ bestScorersData: true });
    console.log(this.state.bestScorersData);
  }

  routeToTribute() {
    this.setState({ bestScorersData: false });
    this.setState({ playerData: false });
    this.setState({ tribute: true });
    console.log(this.state.tribute);
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
              <Button
                variant="dark"
                style={{ margin: 10 }}
                onClick={this.routeToTribute}
              >
                Kobe Bryant Tribute
              </Button>
              {this.state.tribute ? <Redirect to="/kobeTribute" /> : ""}
              <Route path="/getPlayerData" component={GetPlayerData} />
              <Route
                path="/getBestScorersData"
                component={GetBestScorersData}
              />
              <Route path="/kobeTribute" component={KobeVideo} />
            </Router>
          </div>
        </div>
      </React.Fragment>
    );
  }
}

export default App;
