//
//  TransactionsViewModel.swift
//  cacheMeSwiftApp
//
//  Created by Kaitlyn Sookdhew on 2024/07/20.
//

import Foundation

class TransactionViewModel{

    // MARK: Variables
    private weak var delegate: ViewModelDelegate?
    private var repository: TransactionRepositoryType?
    var transaction: TransactionModel?

    init(repository:TransactionRepositoryType , delegate: ViewModelDelegate) {
        self.repository = repository
        self.delegate = delegate
    }

    func fetchResult() {
        repository?.fetchTransactionResults{ [weak self] result in
            switch result {
            case .success(let transaction):
                self?.transaction = transaction
                self?.delegate?.reloadView()
            case .failure(let error):
                self?.delegate?.show(error: error.rawValue)
            }
        }
    }
}
