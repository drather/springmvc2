package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {
    MessageCodesResolver messageCodesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject () {
        String[] messageCodes = messageCodesResolver.resolveMessageCodes("required", "item");
        Assertions.assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        String[] messageCodes = messageCodesResolver.resolveMessageCodes("required", "item", "itemName", String.class);

        // rejectValue() 에서, resolveMessageCodes() 호출
        // FieldError 를 생성할 때, 생성자 중 하나인 codes 에 messageCodes 를 파라미터로 넘김
        // 타임리프가 생성돈 FieldError 에서 적절한 에러메시지를 찾아 화면에 뿌림

        Assertions.assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}
