package io.cosmos.assign.distribute;

public enum DistributorType {

    ROUND_ROBIN(1),
    PERFORMANCE(2);

    private final int code;

    DistributorType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

//    public static DistributorType fromCode(int code) {
//        for (DistributorType type : values()) {
//            if (type.code == code) {
//                return type;
//            }
//        }
//        throw new IllegalArgumentException("Unknown DistributorType code: " + code);
//    }