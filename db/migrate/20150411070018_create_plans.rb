class CreatePlans < ActiveRecord::Migration
  def change
    create_table :plans do |t|
      t.integer :weeks

      t.timestamps
    end
  end
end
