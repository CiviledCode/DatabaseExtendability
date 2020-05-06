# DatabaseExtendability

DatabaseExtendability is an advanced but easily usable sql query API for NukkitX 2.0

Usage for SQLite:
```java
class PlayerDatabase extends SQLiteDatabase {
    public PlayerDatabase(File file) {
        super(file);
        super.connect();
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
```

Usage for MySQL:
```java
class PlayerDatabase extends MySQLDatabase {
    public PlayerDatabase(String username, String password, String ip, String databaseName, int port) {
        super(username, password, ip, databaseName, port);
        super.connect();
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
```

