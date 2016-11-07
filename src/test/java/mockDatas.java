
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class mockDatas {

    public static void main(String[] args) {

        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";

        // URL指向要访问的数据库名
        String url = "jdbc:mysql://127.0.0.1:3306/report";

        // MySQL配置时的用户名
        String user = "root";

        // MySQL配置时的密码
        String password = "123456";

        try {
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, user, password);

            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");

            Statement statement = conn.createStatement();

//			String showTables = "show tables";
//
//			ResultSet rs = statement.executeQuery(showTables);
//
//			System.out.println("-----------------");
            ResultSet rs=null;

            List tableLists = new ArrayList();
            //tableLists.add("rpt_ci_cinema_summary_dt");
            //tableLists.add("bm_ykfp_cinema_film_hall_ticket_dt");
            //tableLists.add("rpt_fm_cinema_film_ticket_dt");
            //tableLists.add("rpt_ci_cinema_hall_ticket_dt");
            //tableLists.add("rpt_ci_cinema_payment_ticket_dt");
            //tableLists.add("rpt_shop_cinema_goods_trade_dt");
            //tableLists.add("rpt_shop_cinema_goods_chanl_trade_dt");

            //tableLists.add("rpt_shop_cinema_goods_item_trade_dt");
            //tableLists.add("rpt_shop_cinema_goods_combo_item_trade_dt");
            //tableLists.add("rpt_fm_cinema_film_summary_dt");
            tableLists.add("users");
            System.out.println(tableLists);

			/*while (rs.next()) {
				String name = rs.getString(1);
				if (name.startsWith("rpt") && name.endsWith("dt") && name.indexOf("_tr_") == -1)
					tableLists.add(name);
			}*/

            // list2.stream().forEach(key -> System.out.println(key));
            //tableLists.stream().forEach(System.out::println);

            System.out.println("-----------------");

            List dateLists = new ArrayList();

            Date d1 = new SimpleDateFormat("yyyyMMdd").parse("20150101");//定义起始日期
            Date d2 = new SimpleDateFormat("yyyyMMdd").parse("20160801");//定义结束日期
            Calendar dd = Calendar.getInstance();//定义日期实例
            dd.setTime(d1);//设置日期起始时间
            while(dd.getTime().before(d2)){//判断是否到结束日期
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                java.lang.String str = sdf.format(dd.getTime());
                System.out.println(str);//输出日期结果
                dd.add(Calendar.DATE, 1);//进行当前日期加1
                dateLists.add(str);
            }
			/*for (int i = 20160101; i < 20160132; i++) {
				dateLists.add(String.valueOf(i));

			}*/
            System.out.println("-----------------" + dateLists.size());
            //dateLists.stream().forEach(System.out::println);

            for (int k = 0; k <dateLists.size(); k++) {
                String dateStr=(String)dateLists.get(k);
                System.out.println("----------" + dateStr);

                for (int j = 0; j < tableLists.size(); j++) {

                    String tableName = (String) tableLists.get(j);

                    String descTable = "desc " + tableName;

                    rs = statement.executeQuery(descTable);

                    List columnNameList = new ArrayList();

                    while (rs.next()) {
                        String name = rs.getString(1);
                        if (name != null)
                            columnNameList.add(name);
                    }
                    System.out.println("-----------------");

                    // String sqlSelect = "select * from
                    // "+"rpt_ci_cinema_chanl_new_trade_dt";
                    // String sqlInsert = "insert into student (Name,Sex,Age)
                    // values(?,?,?)";

                    String insertTable = "replace into" + " " + tableName + " " + "( ";
                    int columnNameSize = columnNameList.size();
                    for (int i = 0; i < columnNameSize; i++) {
                        insertTable += columnNameList.get(i);
                        if (i != columnNameSize - 1)
                            insertTable += ",";
                    }
                    insertTable += " )";

                    // ******Need change the date "20160502" to dateStr
                    insertTable += " select '"+ dateStr +"' AS BIZDATE,";

                    for (int i = 1; i < columnNameSize; i++) {
                        insertTable += columnNameList.get(i);
                        if (i != columnNameSize - 1)
                            insertTable += ",";
                    }

                    insertTable += " from " + tableName + " where biz_date='20160801' "+";";//+ " where biz_date='20160601' "

                    System.out.println("" + insertTable);

                    statement.execute(insertTable);

                    System.out.println("--####Finished execute insert into table : " + tableName);
                }

            }

            rs.close();

        } catch (ClassNotFoundException e) {

            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        } finally{
            System.out.println("********************All Completed*****************");
        }
    }
}
