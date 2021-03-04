

import java.sql.SQLException;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		bankdao abcBankdao=new bankdao();
		
		
		bank leiBank=new bank();
		leiBank.setaccountnum(234);
		leiBank.setbalance(21312312);
		leiBank.setName("123qweqw");
		leiBank.setmail("pooouoil");
		leiBank.setphonenum("831231");
		//abcBankdao.insertUser(leiBank);
		
		
		abcBankdao.deleteUser(4325);
		abcBankdao.selectUser(234);
		abcBankdao.selectAllUsers();
		
		leiBank.setaccountnum(234);
		leiBank.setbalance(21312312);
		leiBank.setName("123qweqw");
		leiBank.setmail("sl13733820@gmail.com");
		leiBank.setphonenum("831231");
		abcBankdao.updateUser(leiBank);
		
	}

}
