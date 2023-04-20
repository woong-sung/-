package jojo.shop.object;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class Dto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ObjectRes {
        public String name;
        public String category;
        public int ea;
        public LocalDateTime modifiedAt;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ObjectInput {
        private String name;
        private String category;
        private int ea;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CategoryRes {
        private List<Dto.Name> list;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MainRes {
        private List<OrderByCategoryRes> data;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderByCategoryRes {
        private String category;
        private List<ObjectRes> objectResList;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NumberInput {
        private String name;
        private int number;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Name {
        public String name;
    }
}
