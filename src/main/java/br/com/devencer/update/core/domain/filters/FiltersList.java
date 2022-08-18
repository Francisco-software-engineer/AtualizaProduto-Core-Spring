package br.com.devencer.update.core.domain.filters;

public enum FiltersList {
    UPDATE_ITEMS_FILTER {
        public Filters get() {
            return new UpdateProductFilter();
        }
    },
    ADDED_ITEMS_FILTER {
        public Filters get() {
            return new NewProductFilter();
        }
    };

    public abstract Filters get();
}

