package jojo.shop.object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class Dto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ObjectRes {
        private String name;
        private int ea;
        private LocalDateTime modifiedAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ObjectInput {
        private String name;
        private String category;
        private int ea;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CategoryRes {
        private List<Dto.Name> list;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MainRes {
        private List<OrderByCategoryRes> data;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderByCategoryRes {
        private String category;
        private List<ObjectRes> objectResList;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NumberInput {
        private String name;
        private int number;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Name {
        private String name;
    }
}
