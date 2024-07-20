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
        super.viewDidLoad()

    }
    

}


extension  ProfileViewController: ViewModelDelegate {

    func reloadView(){
        balance.text = "\(viewModel.balance)"
    }

    func show(error: String) {
    }
}
