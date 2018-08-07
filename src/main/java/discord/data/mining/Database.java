package discord.data.mining;

import com.rethinkdb.net.Connection;

import static com.rethinkdb.RethinkDB.r;

/**
 * @author Hax
 * @github github.com/Schlauer-Hax
 * @time 19:40 07.08.2018
 * @project Discord-Data-Mining
 * @package discord.data.mining
 * @class Database
 **/

public class Database {

    static Connection conn;

    public static void connect() {
        conn = r.connection()
                .hostname("localhost")
                .db("DM")
                .port(28015)
                .connect();
    }

    public static Connection getConn() {
        return conn;
    }
}
