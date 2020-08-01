package Nba.webApp.data;

import Nba.dataModel.PlayerData;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DataAccess {
    private JdbcTemplate jdbcTemplate;

    public void setup(String driverClass, String url, String user, String pass) throws SQLException {

        //initialize the data source
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(driverClass);
        bds.setUrl(url);
        bds.setUsername(user);
        bds.setPassword(pass);
        bds.setValidationQuery("SELECT 1");
        bds.setTestOnBorrow(true);
        bds.setDefaultAutoCommit(true);

        //check that everything works OK
        bds.getConnection().close();

        //initialize the jdbc template utility
        jdbcTemplate = new JdbcTemplate(bds);
    }
    public List<PlayerData> getAllPlayersData (String playerName){

        List<PlayerData> playerData = null;

        Object[] queryParams = new Object[] {
               playerName,
               playerName
        };

        String sqlQuery = "select players.player ,players.height, players.weight, players.college, players.YearBorn, players.Birth_City, players.Birth_State," + 
            "seasons.position, seasons.age, seasons.team, seasons.games, seasons.mp, seasons.per, seasons.fg, seasons.fga, seasons.3P, seasons.3Pa, seasons.ft," + 
            "seasons.fta, seasons.trb, seasons.ast, seasons.stl, seasons.blk, seasons.tov, seasons.pts" + 
            " from nba.players,nba.seasons " + 
            " where players.player=? and seasons.Player=?";

        try{
            System.out.println( sqlQuery);
            playerData = jdbcTemplate.query(sqlQuery, queryParams, (ResultSet rs, int rowNum) -> {
                PlayerData player = new PlayerData();
                player.setPlayerName(rs.getString(1)); //get the data fromt he mysql query to a PlayerData object
                player.setPlayerHeight(rs.getInt(2));
                player.setPlayerWeight(rs.getInt(3));
                player.setCollege(rs.getString(4));
                player.setYearBorn(rs.getInt(5));
                player.setBirthCity(rs.getString(6));
                player.setBirthState(rs.getString(7));
                player.setPosition(rs.getString(8));
                player.setAge(rs.getInt(9));
                player.setTeam(rs.getString(10));
                player.setGames(rs.getInt(11));
                player.setMinutesPlayed(rs.getInt(12));
                player.setPerformanceIndexrating(rs.getFloat(13));
                player.setfG(rs.getInt(14));
                player.setfGA(rs.getInt(15));
                player.setT3P(rs.getInt(16));
                player.setT3PA(rs.getInt(17));
                player.setfT(rs.getInt(18));
                player.setfTA(rs.getInt(19));
                player.settRB(rs.getInt(20));
                player.setaST(rs.getInt(21));
                player.setsTL(rs.getInt(22));
                player.setbLK(rs.getInt(23));
                player.settOV(rs.getInt(24));
                player.setPoints(rs.getInt(25));

                return player;

            });
        }
        catch (DataAccessException e) {
            e.printStackTrace();
        }
        return playerData;
    }
    public List<PlayerData> getBestScorers (String year){

        List<PlayerData> playerData = null;

        Object[] queryParams = new Object[] {
               year
        };

        String sqlQuery = "select players.player ,players.height, players.weight, players.college, players.YearBorn, players.Birth_City, players.Birth_State," + 
            "seasons.position, seasons.age, seasons.team, seasons.games, seasons.mp, seasons.per, seasons.fg, seasons.fga, seasons.3P, seasons.3Pa, seasons.ft," + 
            "seasons.fta, seasons.trb, seasons.ast, seasons.stl, seasons.blk, seasons.tov, seasons.pts" + 
            " from nba.players,nba.seasons " + 
            "  where seasons.year=? and seasons.player=players.player " +
            "order by (seasons.pts/seasons.games) desc limit 15";

        try{
            System.out.println( sqlQuery);
            playerData = jdbcTemplate.query(sqlQuery, queryParams, (ResultSet rs, int rowNum) -> {
                PlayerData player = new PlayerData();
                player.setPlayerName(rs.getString(1)); //get the data fromt he mysql query to a PlayerData object
                player.setPlayerHeight(rs.getInt(2));
                player.setPlayerWeight(rs.getInt(3));
                player.setCollege(rs.getString(4));
                player.setYearBorn(rs.getInt(5));
                player.setBirthCity(rs.getString(6));
                player.setBirthState(rs.getString(7));
                player.setPosition(rs.getString(8));
                player.setAge(rs.getInt(9));
                player.setTeam(rs.getString(10));
                player.setGames(rs.getInt(11));
                player.setMinutesPlayed(rs.getInt(12));
                player.setPerformanceIndexrating(rs.getFloat(13));
                player.setfG(rs.getInt(14));
                player.setfGA(rs.getInt(15));
                player.setT3P(rs.getInt(16));
                player.setT3PA(rs.getInt(17));
                player.setfT(rs.getInt(18));
                player.setfTA(rs.getInt(19));
                player.settRB(rs.getInt(20));
                player.setaST(rs.getInt(21));
                player.setsTL(rs.getInt(22));
                player.setbLK(rs.getInt(23));
                player.settOV(rs.getInt(24));
                player.setPoints(rs.getInt(25));

                return player;

            });
        }
        catch (DataAccessException e) {
            e.printStackTrace();
        }
        return playerData;
    }
}
