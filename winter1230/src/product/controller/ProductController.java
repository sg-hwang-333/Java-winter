package product.controller;

import java.util.ArrayList;
import java.util.Scanner;

import product.vo.ProductDAO;
import product.vo.ProductVO;

public class ProductController {
	Scanner s1 = new Scanner(System.in);
	public static final int ADD = 1;
	public static final int USE = 2;
	
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Integer> prices = new ArrayList<Integer>();
	ArrayList<Integer> totalStocks = new ArrayList<Integer>();
	
	
	public void consolController() {
		
		while (true) {
			System.out.print("관리자면 0번, 사용자면 1번을 입력하세요 : ");
			int temp = s1.nextInt();
			if (temp == 0 ) {
				System.out.println("제품을 추가하려면 1번, 자판기를 이용하려면 2번을 입력하세요.");
				int flag = s1.nextInt();
				if (flag == ADD) {
					addStockView();
				} else {
					displayView();
				}
			} else if (temp == 1){
				displayView();
			}
			
			System.out.print("계속하시겠습니까? 끝내려면 0을 누르세요 : ");
			int flag = s1.nextInt();
			if (flag == 0) {
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		ProductController controller = new ProductController();
		controller.consolController();
		ProductDAO dao = new ProductDAO();
		controller.voToDAO(dao);
		

	}
	
	public void voToDAO(ProductDAO dao){
		for (int i = 0; i< names.size(); i++ ) {    
			ProductVO vo = new ProductVO(names.get(i), prices.get(i) , totalStocks.get(i)); 
			dao.insert(vo); 
		}
	}
	
	public void addStockView() {
		System.out.print("제품명, 가격, 초기 재고량을 입력하세요 : ");
		names.add(s1.next());
		prices.add(s1.nextInt());
		totalStocks.add(s1.nextInt());
	}
	
	public void displayView() {
		Scanner s2 = new Scanner(System.in);
		System.out.println("======= 제품화면 =======");
		for (int i = 0; i < names.size(); i++ ) { 
			System.out.println(i +". "+ names.get(i) + " : " + prices.get(i) +"원, 현재 재고 " + totalStocks.get(i) + "개");
		}
		System.out.print("구매할 제품의 번호를 입력하세요 : ");
		int flag = s2.nextInt();
		//재고부족 시
		if (totalStocks.get(flag) == 0) {
			System.out.print("재고가 부족합니다. 제품을 채우려면 1을 선택하세요 : ");
			int temp = s2.nextInt();
			if (temp == 1) {
				System.out.print("재고를 몇 개 채우시겠습니까? : ");
				temp = s2.nextInt();
				totalStocks.set(flag, totalStocks.get(flag)+temp);
				System.out.println("재고가 " + temp + "개 채워졌습니다.");
			}
		}
		System.out.print("투입할 돈을 입력해주세요 : ");
		int money = s1.nextInt();
		if (money < prices.get(flag)) System.out.println("돈이 부족합니다.");
		else {
			System.out.println("계산이 완료되었습니다. 거스름돈 : " + (money - prices.get(flag)) + "원");
			totalStocks.set(flag, totalStocks.get(flag)-1);
		}
		
	}

}
