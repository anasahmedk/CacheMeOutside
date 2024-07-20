//
//  ProfileViewModel.swift
//  cacheMeSwiftApp
//
//  Created by Kaitlyn Sookdhew on 2024/07/20.
//

import Foundation

class ProfileViewModel{

    // MARK: Variables
    private weak var delegate: ViewModelDelegate?
    private var repository: ProfileRepositoryType?
    var balance: Balance?

    init(repository:ProfileRepositoryType , delegate: ViewModelDelegate) {
        self.repository = repository
        self.delegate = delegate
    }

    func fetchDriver(driverName: String?) {
        repository?.fetchProfileResults{ [weak self] result in
            switch result {
            case .success(let balance):
                self?.balance = balance
                self?.delegate?.reloadView()
            case .failure(let error):
                self?.delegate?.show(error: error.rawValue)
            }
        }
    }
}
