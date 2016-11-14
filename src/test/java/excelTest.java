import java.io.IOException;

/**
 * @author kin
 * @version $: v 0.1 2016/10/26 Exp $$
 */
public class excelTest {

        public static void main(String[] args) throws IOException {

//            Workbook newExcel=new HSSFWorkbook();//创建一个excel
//            DBUtil dbUtil=new DBUtil();//数据库工具类
//            Sheet newSheet0=newExcel.createSheet("Person Info");//创建一个sheet
//            String[] title={"MAP_ID","PERSON_CODE","PERSON_NAME","SEX","INSERT_TIME","UPDATE_TIME","POSITION","SALARY","DEPT"};//表头
//            SimpleDateFormat sdf;
//            Row newRow0=newSheet0.createRow(0);//创建表头
//            int i=0;
//            for(String s:title){//写入表头
//                Cell cell=newRow0.createCell(i++);
//                cell.setCellValue(s);
//            }
//            long sql_begin = System.currentTimeMillis();
//            dbUtil.getConn();//数据库连接
//            ArrayList<Person> persons=dbUtil.getPersonAllRecords();//获取记录
//            sdf=new SimpleDateFormat("MM/dd/yyyy");
//            for(i=0;i<persons.size();i++){//写入记录
//                Row newRow=newSheet0.createRow(i+1);
//                newRow.createCell(0).setCellValue(1);
//                newRow.createCell(1).setCellValue(persons.get(i).getPerson_code());
//                newRow.createCell(2).setCellValue(persons.get(i).getPerson_name());
//                newRow.createCell(3).setCellValue(persons.get(i).getSex());
//                newRow.createCell(4).setCellValue(sdf.format(persons.get(i).getInsert_time()));
//                newRow.createCell(5).setCellValue(sdf.format(persons.get(i).getUpdate_time()));
//                newRow.createCell(6).setCellValue(persons.get(i).getPosition());
//                newRow.createCell(7).setCellValue(persons.get(i).getSalary());
//                newRow.createCell(8).setCellValue(persons.get(i).getDept());
//            }
//            sdf=new SimpleDateFormat("yyyyMMddHHmmss");
//            FileOutputStream fos=new FileOutputStream("PersonInfo"+sdf.format(new Date())+System.currentTimeMillis()+".xls");//创建
//            newExcel.write(fos);//向输入流写入数据
//            System.out.println("sql cost :"+(System.currentTimeMillis()-sql_begin)+"ms.");//数据操作花费时间


        }
    }

