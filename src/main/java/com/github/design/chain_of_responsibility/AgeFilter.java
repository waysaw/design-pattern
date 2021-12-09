package com.github.design.chain_of_responsibility;

public class AgeFilter implements Filter {
    @Override
    public boolean doFilter(User user) {
        return 18 >= user.age;
    }

}
