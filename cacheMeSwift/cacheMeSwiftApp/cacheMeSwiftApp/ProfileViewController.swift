//
//  ProfileViewController.swift
//  cacheMeSwiftApp
//
//  Created by Kaitlyn Sookdhew on 2024/07/20.
//

import UIKit

class ProfileViewController: UIViewController {

    @IBOutlet weak var balance: UILabel!
    private lazy var viewModel = ProfileViewModel(repository: ProfileRepository(), delegate: self)


    override func viewDidLoad() {
        viewModel.fetchResult()
        super.viewDidLoad()
    }
}


extension  ProfileViewController: ViewModelDelegate {

    func reloadView(){
        balance.text = "\(viewModel.balance?.amount ?? 0.00)"
    }

    func show(error: String) {
    }
}
