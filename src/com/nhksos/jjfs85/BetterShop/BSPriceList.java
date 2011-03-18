package com.nhksos.jjfs85.BetterShop;

import com.jascotty2.CheckInput;
import com.jascotty2.Item.Item;
import com.jascotty2.PriceList;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.logging.Level;
import org.bukkit.util.config.Configuration;

public class BSPriceList extends PriceList {

    public BSPriceList() {
        // load the pricelist.
        // load();
    }

    public final boolean load() {
        sortOrder = BetterShop.config.sortOrder;
        useCache = BetterShop.config.useDBCache;
        dbCacheTTL = BetterShop.config.priceListLifespan;//.intValue();
        if (BetterShop.config.useMySQL()) {
            try {
                //System.out.println("attempting MySQL");
                if (loadMySQL(BetterShop.config.sql_database,
                        BetterShop.config.tableName,
                        BetterShop.config.sql_username,
                        BetterShop.config.sql_password,
                        BetterShop.config.sql_hostName,
                        BetterShop.config.sql_portNum)) {
                    BetterShop.Log(Level.INFO, "MySQL database " + pricelistName() + " loaded.");
                    loadOldPricelist();
                    return true;
                }
            } catch (SQLException ex) {
                BetterShop.Log(Level.SEVERE, ex);
            } catch (Exception ex) {
                BetterShop.Log(Level.SEVERE, ex);
            }
            BetterShop.Log(Level.SEVERE, "Failed to connedt to MySQL database "
                    + BetterShop.config.sql_database);

        } else {
            try {
                //System.out.println("attempting FlatFile: " + BSConfig.pluginFolder.getPath() + File.separatorChar + BetterShop.config.tableName + ".csv");
                if (loadFile(new File(BSConfig.pluginFolder.getPath() + File.separatorChar
                        + BetterShop.config.tableName + ".csv"))) {
                    BetterShop.Log(Level.INFO, BetterShop.config.tableName + ".csv loaded.");
                    loadOldPricelist();
                    return true;
                }
            } catch (IOException ex) {
                BetterShop.Log(Level.SEVERE, ex);
            } catch (Exception ex) {
                BetterShop.Log(Level.SEVERE, ex);
            }
            BetterShop.Log(Level.SEVERE, "Failed to load pricelist database " + BetterShop.config.tableName + ".csv "
                    + BetterShop.config.sql_database);
        }
        return false;
    }

    public void loadOldPricelist() {
        File oldFile = new File(BSConfig.pluginFolder.getPath() + File.separatorChar + "PriceList.yml");
        if (oldFile.exists()) {
            try {
                BetterShop.Log("Found old PriceList.yml file");
                Configuration PriceList = new Configuration(oldFile);
                PriceList.load();
                if (PriceList.getNode("prices") != null) {
                    for (String itn : PriceList.getKeys("prices")) {
                        if (itn.startsWith("item")) {
                            int id = 0, sub = 0;
                            if (itn.contains("sub")) {
                                id = CheckInput.GetInt(itn.substring(4, itn.indexOf("sub")), 0);
                                sub = CheckInput.GetInt(itn.substring(itn.indexOf("sub") + 3), 0);
                            } else {
                                id = CheckInput.GetInt(itn.substring(4), 0);
                            }
                            Item toAdd = Item.findItem(id, (byte) sub);
                            if (toAdd != null) {
                                //if(setPrice(toAdd, PriceList.getDouble("prices." + itn + ".buy", -1), PriceList.getDouble("prices." + itn + ".sell", -1)))
                                //System.out.println("Added " + toAdd);
                                setPrice(toAdd, PriceList.getDouble("prices." + itn + ".buy", -1), PriceList.getDouble("prices." + itn + ".sell", -1));
                            } else {
                                BetterShop.Log("Invalid Item: " + itn);
                            }
                        } else {
                            BetterShop.Log("Invalid Item: " + itn);
                        }
                    }
                }
                oldFile.renameTo(new File(BSConfig.pluginFolder.getPath() + File.separatorChar + "OLD_PriceList.yml"));
                save();
                BetterShop.Log("Old Pricelist Imported Successfully ");
            } catch (SQLException ex) {
                BetterShop.Log(Level.SEVERE, ex);
            } catch (IOException ex) {
                BetterShop.Log(Level.SEVERE, ex);
            } catch (Exception ex) {
                BetterShop.Log(Level.SEVERE, ex);
            }
        }
    }

    public boolean setPrice(String item, String b, String s) {
        try {
            double bp = CheckInput.GetDouble(b, -1);
            double sp = CheckInput.GetDouble(s, -1);
            return setPrice(Item.findItem(item), bp < 0 ? -1 : bp, sp < 0 ? -1 : sp);
        } catch (SQLException ex) {
            BetterShop.Log(Level.SEVERE, ex);
        } catch (Exception ex) {
            BetterShop.Log(Level.SEVERE, ex);
        }
        return false;
    }

    public LinkedList<String> GetShopListPage(int pageNum, boolean isPlayer, boolean showIllegal) {
        try {
            return GetShopListPage(pageNum, isPlayer,
                    BetterShop.config.pagesize,
                    BetterShop.config.getString("listing"),
                    BetterShop.config.getString("listhead"),
                    BetterShop.config.getString("listtail"), showIllegal);
        } catch (SQLException ex) {
            BetterShop.Log(Level.SEVERE, ex);
        } catch (Exception ex) {
            BetterShop.Log(Level.SEVERE, ex);
        }
        // an error occured: let player know
        LinkedList<String> ret = new LinkedList<String>();
        ret.add("\u00A74An Error Occurred while retrieving pricelist.. ");
        ret.add("\u00A74 see the server log or let an OP know of this error");
        return ret;
    }

    public LinkedList<String> GetShopListPage(int pageNum, boolean isPlayer) {
        return GetShopListPage(pageNum, isPlayer, true);
    }
}
