class AddVerificationCodeBoolToUser < ActiveRecord::Migration
  def change
  	add_column :users, :verified, :bool
  end
end
