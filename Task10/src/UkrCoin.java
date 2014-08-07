
public enum UkrCoin {
	ONE(1), TWO(2), FIVE(5), TEN(10), TWFIVE(25), FIFTY(50), HRN(100);
	
	private int coin;
	private UkrCoin(int coin){
		this.coin = coin;
	}
	public int getCoin() {
		return coin;
	}
	/**
	 * return DoublyLinkedList of coins.
	 * @param grn - count of grns
	 * @param coins - count of coins
	 */
	public static DoublyLinkedList<UkrCoin> exchange(int grn, int coins){
		DoublyLinkedList<UkrCoin> dll = new DoublyLinkedList<>();
		UkrCoin[] array = {FIFTY,TWFIVE,TEN,FIVE,TWO,ONE};
		//add grns
		for(int i = 0; i < grn; i++){
			dll.addLast(HRN);
		}
		for(int i = 0; i < array.length; i++){
			int counter = coins / array[i].getCoin();
			for(int j = 0; j < counter; j++){
				dll.addLast(array[i]);
			}
			coins -= counter * array[i].getCoin();
		}
		return dll;
	}
}
