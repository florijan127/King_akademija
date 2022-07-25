import { ComputedPropertyName } from "typescript"

export interface Filter {
    prodName: string,
    brandName: string,
    priceMax: number
}

export interface Item {
    id: number,
    name: string,
    description: string,
    price: number,
    inStock: number,
    brand: Brand
}

export interface Brand {
    id: number,
    name: string
}


export interface Order {
    id: number,
    timestamp: EpochTimeStamp,
    priceWOTax: number,
    priceWTax: number,
    coupon: Coupon,
    payMeth: PayMeth,
    email: string,
    phoneNo: number,
    address: string,
    instructions: string

}

export interface Coupon {
    id: number,
    code: string,
    discount: number
}

export interface PayMeth {
    id: number,
    name: string
}

export interface Cart {
    items: Item[],
}