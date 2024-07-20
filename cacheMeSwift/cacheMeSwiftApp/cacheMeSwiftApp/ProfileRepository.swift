//
//  ProfileRepository.swift
//  cacheMeSwiftApp
//
//  Created by Kaitlyn Sookdhew on 2024/07/20.
//

import Foundation

// MARK: Typealias
typealias ProfileBalancesResults = (Result< Balance, APIError>) -> Void
typealias ProfilePointsResults = (Result< PointBalance, APIError>) -> Void

// MARK: Protocol
protocol ProfileRepositoryType: AnyObject {
    func fetchProfileResults(completion: @escaping(ProfileBalancesResults))
}

// MARK: Repository
class ProfileRepository: ProfileRepositoryType {

    func fetchProfileResults(completion: @escaping (ProfileBalancesResults)) {
        let url = Endpoints.balances
        URLSession.shared.request(endpoint: url, method: .GET) { (result: Result< Balance, APIError>) in
            switch result {
            case .success(let results):
                completion(.success(results))
            case .failure(let error):
                completion(.failure(error))
            }
        }
    }
}
