package examples;

import cn.nukkit.player.Player;
import com.civiledcode.dbextend.Objects.DatabaseEntry;
import com.civiledcode.dbextend.SQLite.SQLiteDatabase;

import java.io.File;

class PlayerDatabase extends SQLiteDatabase {
    public PlayerDatabase(File file) {
        super(file);
    }

    @Override
    public void initiate() {
        try {
            executeUpdate("CREATE TABLE IF NOT EXISTS players (player TEXT, rank TEXT, level INTEGER, kills INTEGER, deaths INTEGER);");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRank(Player player) {
        DatabaseEntry userEntry = executeQuery("SELECT rank WHERE player = '" + player.getServerId().toString() + "';").get(0);
        return userEntry.getString("rank");
    }

    public double getKDR(Player player) {
        DatabaseEntry userEntry = executeQuery("SELECT rank WHERE player = '" + player.getServerId().toString() + "';").get(0);
        return userEntry.getInt("kills") / userEntry.getInt("deaths");
    }
}
