package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fish.FishShop;
import fish.FrozenFish;
import fish.Herring;
import fish.LiveFish;

public class Service {
	
	private List<FishShop> items;
	
	public Service() {
		items = new ArrayList<>();
	}

	public void show(){
		System.out.println("Choose fist type[1-q]:"
				           + "1. add live fish\n"
				           + "2. add frozen fish\n"
				           + "3. add hering\n"
				           + "4. search by price frozen fish"
				           + "5. search by price live fish"
				           + "6. search by price herring"
				           + "7. show sorted list by weight"
				           + "8. exit");
		while(true){
			Scanner sc = new Scanner(System.in);
			int selection = sc.nextInt();
			if(selection == 1){
				System.out.println("Input price live fish:");
				int priceLiveFish = sc.nextInt();
				System.out.println("Input name live fish:");
				String nameLiveFish = sc.nextLine();
				System.out.println("Input weight live fish");
				double weightFish = sc.nextDouble();
				FishShop fishShop = new FishShop(new LiveFish(priceLiveFish, nameLiveFish, weightFish));	
				items.add(fishShop);
				break;
			} else if(selection == 2){
				System.out.println("Input price frozen fish:");
				int priceFrozenFish = sc.nextInt();
				System.out.println("Input name frozen fish:");
				String nameFrozenFish = sc.nextLine();
				System.out.println("Input weight frozen fish");
				double weightFish = sc.nextDouble();
				FishShop fishShop = new FishShop(new FrozenFish(priceFrozenFish, nameFrozenFish, weightFish));
				items.add(fishShop);
				break;
			} else if(selection == 3){
				System.out.println("Input price hering:");
				int priceHerring = sc.nextInt();
				System.out.println("Input name herring:");
				String nameHerring = sc.nextLine();
				System.out.println("Input weight herring");
				double weightFish = sc.nextDouble();
				FishShop fishShop = new FishShop(new Herring(priceHerring, nameHerring, weightFish));
				items.add(fishShop);
				break;
			}  else if(selection == 4){
				for (FishShop fishShop : items) {
					if(fishShop.getFrozenFish().getPrice() >= 50 && fishShop.getFrozenFish().getPrice() <= 100){
						System.out.println(fishShop);
					}
				}
				break;
			} else if(selection == 5){
				for (FishShop fishShop : items) {
					if(fishShop.getLiveFish().getPrice() >= 40 && fishShop.getLiveFish().getPrice() <= 60){
						System.out.println(fishShop);
					}
				}
				break;
			} else if(selection == 6){
				for (FishShop fishShop : items) {
					if(fishShop.getHerring().getPrice() <= 60){
						System.out.println(fishShop);
					}
				}
				break;
			} else if(selection == 7){
				for (FishShop fishShop : items) {
					System.out.println(fishShop);
				}
				break;
			} else if(selection == 8){
				break;
			}
			sc.close();
		}
	}
}

