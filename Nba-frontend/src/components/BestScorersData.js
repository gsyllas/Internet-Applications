import React, { Component } from "react";
import Table from "react-bootstrap/Table";
import { Container } from "react-bootstrap";

class BestScorersData extends Component {
  constructor(props) {
    super(props);
  }

  isEmpty(obj) {
    //check if an object is empty
    for (var key in obj) {
      if (obj.hasOwnProperty(key)) return false;
    }
    return true;
  }

  render() {
    return (
      <div>
        <Container>
          {this.props.displayTable ? (
            <div>
              {!this.isEmpty(this.props.myData) ? (
                <div>
                  <Table
                    style={{
                      overflowY: "scroll",
                      display: "block",
                      maxHeight: "400px",
                      marginLeft: "30px",
                      maxWidth: "850px",
                    }}
                    responsive
                    size="sm"
                    striped
                    bordered
                    hover
                    variant="dark"
                  >
                    {Object.keys(this.props.myData[0]).map((key, index) => {
                      //insert headers
                      return <th key={index}>{key}</th>;
                    })}
                    {this.props.myData.map((myobj, i) => {
                      return (
                        <tbody>
                          <tr>
                            {Object.keys(myobj).map((key, index) => {
                              return <td key={index}>{myobj[key]}</td>; //for each record in the json iterate through the attributes
                            })}
                          </tr>
                        </tbody>
                      );
                    })}
                  </Table>
                </div>
              ) : (
                <div style={{ marginTop: 150, marginLeft: 150 }}>
                  <h1>No Data to display for this input</h1>
                </div>
              )}
            </div>
          ) : (
            ""
          )}
        </Container>
      </div>
    );
  }
}

export default BestScorersData;
