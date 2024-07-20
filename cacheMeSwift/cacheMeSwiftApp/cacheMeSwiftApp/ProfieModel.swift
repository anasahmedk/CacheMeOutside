//
//  ProfieModel.swift
//  cacheMeSwiftApp
//
//  Created by Kaitlyn Sookdhew on 2024/07/20.
//

import Foundation

struct Transaction: Codable {
    let amount: Double
    let description: String
    let scored: Bool
}

struct Balance: Codable {
    let amount: Double
}

struct PointBalance: Codable {
    let amount: Double
}


struct Chat: Codable {
    let message: String
}
