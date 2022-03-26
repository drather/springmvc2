package hello.itemservice.domain.item;

/**
 * ItemType 을 나타내는 enum 크래스
 */
public enum ItemType {
    BOOK("도서"), FOOD("음식"), ETC("기타");
    private final String description;

    ItemType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
