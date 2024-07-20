//
//  TransactionsRepository.swift
//  cacheMeSwiftApp
//
//  Created by Kaitlyn Sookdhew on 2024/07/20.
//

import Foundation


typealias ProfileTransactionResults = (Result< TransactionModel, APIError>) -> Void

// MARK: Protocol
protocol TransactionRepositoryType: AnyObject {
    func fetchTransactionResults(completion: @escaping(ProfileTransactionResults))
}

// MARK: Repository
class TransactionRepository: TransactionRepositoryType {

    func fetchTransactionResults(completion: @escaping (ProfileTransactionResults)) {
        let url = Endpoints.transactions
        URLSession.shared.request(endpoint: url, method: .GET) { (result: Result<TransactionModel, APIError>) in
            switch result {
            case .success(let results):
                completion(.success(results))
            case .failure(let error):
                completion(.failure(error))
            }
        }
    }
}
