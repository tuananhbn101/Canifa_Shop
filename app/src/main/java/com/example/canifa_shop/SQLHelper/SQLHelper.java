package com.example.canifa_shop.SQLHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.canifa_shop.Bill.Object.Bill;
import com.example.canifa_shop.Login.Object.Accounts;
import com.example.canifa_shop.Product.Object.Product;
import com.example.canifa_shop.Report.Objcet.Report;

import java.util.ArrayList;
import java.util.List;

public class SQLHelper extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;
    Cursor cursor;
    static final String DB_NAME = "Data";
    static final String DB_TABLE_ACCOUNT = "Accounts";
    static final String DB_TABLE_PRODUCT = "Products";
    static final String DB_TABLE_ORDER_PRODUCT = "OrderProducts";
    static final String DB_TABLE_REPORT = "Reports";
    static final String DB_TABLE_BILL = "Bills";
    static final String DB_TABLE_LOYALTY_CARD= "Card";
    static final String DB_TABLE_VOUCHER = "Voucher";
    static final int DB_VERSION = 1;
    static final String ACCOUNT_ID = "ID";
    static final String ACCOUNT_USER_NAME = "userName";
    static final String ACCOUNT_PASSWORD = "password";
    static final String ACCOUNT_FULL_NAME = "fullName";
    static final String ACCOUNT_DATE_OF_BIRTH = "dateOfBirth";
    static final String ACCOUNT_PHONE = "phone";
    static final String ACCOUNT_EMAIL = "email";
    static final String ACCOUNT_AVATAR = "avatar";
    static final String ACCOUNT_HOMETOWN = "homeTown";
    static final String ACCOUNT_PERMISSION = "permission";
    static final String PRODUCT_ID = "ID";
    static final String PRODUCT_NAME = "name";
    static final String PRODUCT_PRICE_IMPORT = "priceImport";
    static final String PRODUCT_PRICE = "price";
    static final String PRODUCT_AMOUNT = "amount";
    static final String PRODUCT_TYPE = "type";
    static final String PRODUCT_DESCRIBE = "describe";
    static final String PRODUCT_IMAGE = "image";
    static final String PRODUCT_BARD_CODE
            = "producer";
    static final String REPORT_ID = "IDReport";
    static final String REPORT_DATE = "date";
    static final String REPORT_TOTAL_IMPORT = "totalImport";
    static final String REPORT_TOTAL_SALE = "totalSale";
    static final String REPORT_ID_EMPLOYEE= "IDEmployee";
    static final String BILL_ID = "IDBill";
    static final String BILL_DATE = "date";
    static final String BILL_NAME_PRODUCT = "names";
    static final String BILL_AMOUNT = "amounts";
    static final String BILL_PRICE = "price";
    static final String BILL_TOTAL = "total";
    static final String BILL_ID_EMPLOYEE= "IDEmployee";

    public SQLHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateTableAccounts = "CREATE TABLE Accounts (" +
                "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "userName TEXT NOT NULL," +
                "password TEXT NOT NULL," +
                "fullName TEXT NOT NULL," +
                "dateOfBirth TEXT NOT NULL," +
                "phone TEXT NOT NULL," +
                "question TEXT NOT NULL," +
                "avatar TEXT NOT NULL," +
                "answer TEXT NOT NULL," +
                "permission INTERGER )";
        String queryCreateTableProducts = "CREATE TABLE Products (" +
                "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "priceImport LONG NOT NULL," +
                "price LONG NOT NULL," +
                "amount INTEGER NOT NULL," +
                "type TEXT NOT NULL," +
                "describe TEXT NOT NULL," +
                "image TEXT NOT NULL," +
                "producer TEXT NOT NULL)";
        String queryCreateTableOrderProducts = "CREATE TABLE OrderProducts (" +
                "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "priceImport LONG NOT NULL," +
                "price LONG NOT NULL," +
                "amount INTEGER NOT NULL," +
                "type TEXT NOT NULL," +
                "describe TEXT NOT NULL," +
                "image TEXT NOT NULL," +
                "producer TEXT NOT NULL)";
        String queryCreateTableReports = "CREATE TABLE Reports (" +
                "IDReport INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "date TEXT NOT NULL," +
                "totalImport TEXT NOT NULL," +
                "totalSale LONG,"+
                "IDEmployee INTERGER)";
        String queryCreateTableBillProducts = "CREATE TABLE Bills (" +
                "IDBill INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "date TEXT NOT NULL," +
                "names TEXT NOT NULL," +
                "amounts TEXT NOT NULL," +
                "price TEXT NOT NULL," +
                "total LONG NOT NULL,"+
                "IDEmployee INTERGER)";
        db.execSQL(queryCreateTableAccounts);
        db.execSQL(queryCreateTableProducts);
        db.execSQL(queryCreateTableOrderProducts);
        db.execSQL(queryCreateTableReports);
        db.execSQL(queryCreateTableBillProducts);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
            onCreate(db);
        }
    }
    public void insertAccount(Accounts account) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        //contentValues.put(ACCOUNT_ID, account.getID());
        contentValues.put(ACCOUNT_USER_NAME, account.getUserName());
        contentValues.put(ACCOUNT_PASSWORD, account.getPassword());
        contentValues.put(ACCOUNT_FULL_NAME, account.getFullName());
        contentValues.put(ACCOUNT_DATE_OF_BIRTH, account.getDateOfBirth());
        contentValues.put(ACCOUNT_PHONE, account.getPhone());
        contentValues.put(ACCOUNT_HOMETOWN, account.getHomeTown());
        contentValues.put(ACCOUNT_EMAIL, account.getEmail());
        contentValues.put(ACCOUNT_AVATAR, account.getAvatar());
        contentValues.put(ACCOUNT_PERMISSION,account.getPermission());
        sqLiteDatabase.insert(DB_TABLE_ACCOUNT, null, contentValues);
        contentValues.clear();
    }

    public void updateAccount(Accounts account) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        //contentValues.put(ACCOUNT_ID, account.getID());
        contentValues.put(ACCOUNT_USER_NAME, account.getUserName());
        contentValues.put(ACCOUNT_PASSWORD, account.getPassword());
        contentValues.put(ACCOUNT_FULL_NAME, account.getFullName());
        contentValues.put(ACCOUNT_DATE_OF_BIRTH, account.getDateOfBirth());
        contentValues.put(ACCOUNT_PHONE, account.getPhone());
        contentValues.put(ACCOUNT_HOMETOWN, account.getHomeTown());
        contentValues.put(ACCOUNT_EMAIL, account.getEmail());
        contentValues.put(ACCOUNT_AVATAR, account.getAvatar());
        contentValues.put(ACCOUNT_PERMISSION,account.getPermission());
        sqLiteDatabase.update(DB_TABLE_ACCOUNT, contentValues, "ID = ?", new String[]{String.valueOf(account.getAccountID())});
        contentValues.clear();
    }

    public void deleteAccount(int id) {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(DB_TABLE_ACCOUNT, "ID = ?",new String[]{String.valueOf(id)} );
    }

    public List<Accounts> getAllAccounts() {
        List<Accounts> accountList = new ArrayList<>();
        Accounts account;
        sqLiteDatabase = getReadableDatabase();
        try {
            cursor = sqLiteDatabase.query(false, DB_TABLE_ACCOUNT, null, null, null, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cursor != null)
            while (cursor.moveToNext()) {
                int ID = cursor.getInt(cursor.getColumnIndex(ACCOUNT_ID));
                String userName = cursor.getString(cursor.getColumnIndex(ACCOUNT_USER_NAME));
                String password = cursor.getString(cursor.getColumnIndex(ACCOUNT_PASSWORD));
                String fullName = cursor.getString(cursor.getColumnIndex(ACCOUNT_FULL_NAME));
                String dateOfBirth = cursor.getString(cursor.getColumnIndex(ACCOUNT_DATE_OF_BIRTH));
                String phone = cursor.getString(cursor.getColumnIndex(ACCOUNT_PHONE));
                String email = cursor.getString(cursor.getColumnIndex(ACCOUNT_EMAIL));
                String homeTown = cursor.getString(cursor.getColumnIndex(ACCOUNT_HOMETOWN));
                String permission = cursor.getString(cursor.getColumnIndex(ACCOUNT_PERMISSION));
                String avatar = cursor.getString(cursor.getColumnIndex(ACCOUNT_AVATAR));
                account = new Accounts(ID, userName, password, fullName, dateOfBirth, phone,email,homeTown,avatar,permission);
                accountList.add(account);
            }
        return accountList;
    }

    public void insertProduct(Product product) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        //contentValues.put(ACCOUNT_ID, account.getID());
        contentValues.put(PRODUCT_NAME, product.getNameProduct());
        contentValues.put(PRODUCT_PRICE_IMPORT, product.getImportprice());
        contentValues.put(PRODUCT_PRICE, product.getPrice());
        contentValues.put(PRODUCT_AMOUNT, product.getAmount());
        contentValues.put(PRODUCT_TYPE, product.getType());
        contentValues.put(PRODUCT_DESCRIBE, product.getDescribe());
        contentValues.put(PRODUCT_IMAGE, product.getImage());
        contentValues.put(PRODUCT_BARD_CODE
                , product.getBardCode());
        sqLiteDatabase.insert(DB_TABLE_PRODUCT, null, contentValues);
    }

    public void updateProduct(Product product) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        //contentValues.put(ACCOUNT_ID, account.getID());
        contentValues.put(PRODUCT_NAME, product.getNameProduct());
        contentValues.put(PRODUCT_PRICE_IMPORT, product.getImportprice());
        contentValues.put(PRODUCT_PRICE, product.getPrice());
        contentValues.put(PRODUCT_AMOUNT, product.getAmount());
        contentValues.put(PRODUCT_TYPE, product.getType());
        contentValues.put(PRODUCT_DESCRIBE, product.getDescribe());
        contentValues.put(PRODUCT_IMAGE, product.getImage());
        contentValues.put(PRODUCT_BARD_CODE
                , product.getBardCode());
        sqLiteDatabase.update(DB_TABLE_PRODUCT, contentValues, "ID = ?", new String[]{String.valueOf(product.getID())});
    }


    public void deleteAllProduct() {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(DB_TABLE_PRODUCT, null, null);
    }

    public void deleteItemProduct(int ID) {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(DB_TABLE_PRODUCT, "ID = ?", new String[]{String.valueOf(ID)});
    }

    public List<Product> getAllPrduct() {
        List<Product> productList = new ArrayList<>();
        Product product;
        sqLiteDatabase = getReadableDatabase();
        try {
            cursor = sqLiteDatabase.query(false, DB_TABLE_PRODUCT, null, null, null, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cursor != null)
            while (cursor.moveToNext()) {
                int ID = cursor.getInt(cursor.getColumnIndex(ACCOUNT_ID));
                String nameProduct = cursor.getString(cursor.getColumnIndex(PRODUCT_NAME));
                long priceImport = cursor.getLong(cursor.getColumnIndex(PRODUCT_PRICE_IMPORT));
                long price = cursor.getLong(cursor.getColumnIndex(PRODUCT_PRICE));
                int amount = cursor.getInt(cursor.getColumnIndex(PRODUCT_AMOUNT));
                String type = cursor.getString(cursor.getColumnIndex(PRODUCT_TYPE));
                String describe = cursor.getString(cursor.getColumnIndex(PRODUCT_DESCRIBE));
                String image = cursor.getString(cursor.getColumnIndex(PRODUCT_IMAGE));
                String bardCode = cursor.getString(cursor.getColumnIndex(PRODUCT_BARD_CODE
                ));
                productList.add(new Product(ID, nameProduct,priceImport, price, amount, type, describe, image, bardCode));
            }
        return productList;
    }

    public void insertOrderProduct(Product product) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        //contentValues.put(ACCOUNT_ID, account.getID());
        contentValues.put(PRODUCT_NAME, product.getNameProduct());
        contentValues.put(PRODUCT_PRICE_IMPORT, product.getImportprice());
        contentValues.put(PRODUCT_PRICE, product.getPrice());
        contentValues.put(PRODUCT_AMOUNT, product.getAmount());
        contentValues.put(PRODUCT_TYPE, product.getType());
        contentValues.put(PRODUCT_DESCRIBE, product.getDescribe());
        contentValues.put(PRODUCT_IMAGE, product.getImage());
        contentValues.put(PRODUCT_BARD_CODE
                , product.getBardCode());
        sqLiteDatabase.insert(DB_TABLE_ORDER_PRODUCT, null, contentValues);
    }

    public void updateOrderProduct(Product product) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        //contentValues.put(ACCOUNT_ID, account.getID());
        contentValues.put(PRODUCT_NAME, product.getNameProduct());
        contentValues.put(PRODUCT_PRICE, product.getPrice());
        contentValues.put(PRODUCT_PRICE_IMPORT, product.getImportprice());
        contentValues.put(PRODUCT_AMOUNT, product.getAmount());
        contentValues.put(PRODUCT_TYPE, product.getType());
        contentValues.put(PRODUCT_DESCRIBE, product.getDescribe());
        contentValues.put(PRODUCT_IMAGE, product.getImage());
        contentValues.put(PRODUCT_BARD_CODE
                , product.getBardCode());
        sqLiteDatabase.update(DB_TABLE_ORDER_PRODUCT, contentValues, "ID = ?", new String[]{String.valueOf(product.getID())});
    }

    public void deleteOrderProduct() {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(DB_TABLE_ORDER_PRODUCT, null, null);
    }

    public void deleteItemOrderProduct(int ID) {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(DB_TABLE_ORDER_PRODUCT, "ID = ?", new String[]{String.valueOf(ID)});
    }

    public List<Product> getAllOrderPrduct() {
        List<Product> productList = new ArrayList<>();
        Product product;
        sqLiteDatabase = getReadableDatabase();
        try {
            cursor = sqLiteDatabase.query(false, DB_TABLE_ORDER_PRODUCT, null, null, null, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cursor != null)
            while (cursor.moveToNext()) {
                int ID = cursor.getInt(cursor.getColumnIndex(ACCOUNT_ID));
                String nameProduct = cursor.getString(cursor.getColumnIndex(PRODUCT_NAME));
                long priceImport = cursor.getLong(cursor.getColumnIndex(PRODUCT_PRICE_IMPORT));
                long price = cursor.getLong(cursor.getColumnIndex(PRODUCT_PRICE));
                int amount = cursor.getInt(cursor.getColumnIndex(PRODUCT_AMOUNT));
                String type = cursor.getString(cursor.getColumnIndex(PRODUCT_TYPE));
                String describe = cursor.getString(cursor.getColumnIndex(PRODUCT_DESCRIBE));
                String image = cursor.getString(cursor.getColumnIndex(PRODUCT_IMAGE));
                String producer = cursor.getString(cursor.getColumnIndex(PRODUCT_BARD_CODE
                ));
                productList.add(new Product(ID, nameProduct, priceImport ,price, amount, type, describe, image, producer));
            }
        return productList;
    }

    public void insertReport(Report report) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
//        contentValues.put(REPORT_ID,report.getId());
        contentValues.put(REPORT_DATE, report.getDate());
        contentValues.put(REPORT_TOTAL_IMPORT ,report.getTotalImport());
        contentValues.put(REPORT_TOTAL_SALE, report.getTotalSale());
        contentValues.put(REPORT_ID_EMPLOYEE, report.getIDEmployee());
        sqLiteDatabase.insert(DB_TABLE_REPORT, null, contentValues);
    }

    public List<Report> getAllReport() {
        List<Report> reportArrayList = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        try {
            cursor = sqLiteDatabase.query(false, DB_TABLE_REPORT, null, null, null, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cursor != null)
            while (cursor.moveToNext()) {
                int ID = cursor.getInt(cursor.getColumnIndex(REPORT_ID));
                long totalImport = cursor.getInt(cursor.getColumnIndex(REPORT_TOTAL_IMPORT));
                long totalSale = cursor.getLong(cursor.getColumnIndex(REPORT_TOTAL_SALE));
                String date = cursor.getString(cursor.getColumnIndex(REPORT_DATE));
                int IDEmployees = cursor.getInt(cursor.getColumnIndex(REPORT_ID_EMPLOYEE));
                reportArrayList.add(new Report(date, ID, totalImport, totalSale,IDEmployees));
            }
        return reportArrayList;
    }
    public void insertBill(Bill bill) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
//        contentValues.put(REPORT_ID,report.getId());
        contentValues.put(BILL_DATE, bill.getDate());
        contentValues.put(BILL_NAME_PRODUCT, bill.getNames());
        contentValues.put(BILL_AMOUNT, bill.getAmount());
        contentValues.put(BILL_PRICE, bill.getPrice());
        contentValues.put(BILL_TOTAL, bill.getTotal());
        contentValues.put(BILL_ID_EMPLOYEE, bill.getIDEmployee());
        sqLiteDatabase.insert(DB_TABLE_BILL, null, contentValues);
    }

    public List<Bill> getAllBill() {
        List<Bill> billArrayList = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        try {
            cursor = sqLiteDatabase.query(false, DB_TABLE_BILL, null, null, null, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cursor != null)
            while (cursor.moveToNext()) {
                int ID = cursor.getInt(cursor.getColumnIndex(BILL_ID));
                String date = cursor.getString(cursor.getColumnIndex(BILL_DATE));
                String nameProduct = cursor.getString(cursor.getColumnIndex(BILL_NAME_PRODUCT));
                String amount = cursor.getString(cursor.getColumnIndex(BILL_AMOUNT));
                String price = cursor.getString(cursor.getColumnIndex(BILL_PRICE));
                long total = cursor.getLong(cursor.getColumnIndex(BILL_TOTAL));
                int IDEmployees = cursor.getInt(cursor.getColumnIndex(BILL_ID_EMPLOYEE));
                billArrayList.add(new Bill(ID,date,nameProduct, amount, price,total,IDEmployees));
            }
        return billArrayList;
    }
}
